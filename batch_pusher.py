import subprocess
import os
import time

def run_command(command):
    try:
        result = subprocess.run(command, shell=True, check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
        return result.stdout.strip()
    except subprocess.CalledProcessError as e:
        print(f"Error running command: {command}")
        print(e.stderr)
        raise

def main():
    # 1. Get list of all modified and untracked files
    print("Getting list of files...")
    # git status --porcelain lists files with status codes.
    # We want to add all of them.
    status_output = run_command("git status --porcelain")
    
    files_to_add = []
    for line in status_output.splitlines():
        # Status line format: "XY PATH"
        # X=index status, Y=worktree status. 
        # Typically " M", "??", " D", etc.
        # We process all.
        parts = line.strip().split(" ", 1)
        if len(parts) < 2:
            continue
        # The file path is the second part (git status might quote it if it has spaces, but usually just path)
        # If it's quoted, we might need to handle that, but for now assuming simple paths or handle quotes if needed.
        file_path = parts[1]
        # remove quotes if present
        if file_path.startswith('"') and file_path.endswith('"'):
            file_path = file_path[1:-1]
        
        files_to_add.append(file_path)

    print(f"Found {len(files_to_add)} files to process.")

    # 2. Add .gitignore explicitly first if it's in the list, to ensure rules are applied
    if ".gitignore" in files_to_add:
        run_command("git add .gitignore")
        run_command('git commit -m "Update .gitignore"')
        run_command("git push origin main")
        files_to_add.remove(".gitignore")
        print("Pushed .gitignore")

    # 3. Process in batches
    BATCH_SIZE = 10
    total_files = len(files_to_add)
    
    for i in range(0, total_files, BATCH_SIZE):
        batch = files_to_add[i : i + BATCH_SIZE]
        if not batch:
            continue
            
        print(f"Processing batch {i//BATCH_SIZE + 1} ({len(batch)} files)...")
        
        # Join files with quotes to handle spaces
        # Escape quotes in filename if necessary (simple approach)
        batch_files_str = " ".join([f'"{f}"' for f in batch])
        
        try:
            # Add
            run_command(f"git add {batch_files_str}")
            
            # Commit
            commit_msg = f"Batch upload: {i+1} to {min(i+BATCH_SIZE, total_files)} of {total_files}"
            run_command(f'git commit -m "{commit_msg}"')
            
            # Push
            print("Pushing...")
            run_command("git push origin main")
            
            print(f"Batch {i//BATCH_SIZE + 1} complete.")
            
        except Exception as e:
            print(f"Failed at batch {i//BATCH_SIZE + 1}. Stopping.")
            break

if __name__ == "__main__":
    main()
