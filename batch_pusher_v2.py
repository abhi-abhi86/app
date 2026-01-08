import subprocess
import os
import sys

def run(cmd):
    # print(f"Running: {cmd}")
    subprocess.run(cmd, shell=True, check=True)

def get_output(cmd):
    return subprocess.check_output(cmd, shell=True, text=True).strip()

def main():
    print("Preparing file list...")
    
    # 1. Stage everything to get a clean list of what git tracks
    run("git add .")
    
    # 2. Get list of staged files
    try:
        files_output = get_output("git diff --name-only --cached")
    except:
        files_output = ""
        
    all_files = [f for f in files_output.splitlines() if f.strip()]
    
    print(f"Total files to commit: {len(all_files)}")
    
    # 3. Unstage everything so we can batch them
    run("git reset")
    
    # 4. Batch process
    BATCH_SIZE = 10
    total = len(all_files)
    
    if total == 0:
        print("No files to commit.")
        return

    for i in range(0, total, BATCH_SIZE):
        chunk = all_files[i : i + BATCH_SIZE]
        print(f"Processing batch {i//BATCH_SIZE + 1} ({len(chunk)} files)...")
        
        # Escape paths
        # We put paths in quotes. 
        # Note: git adds files relative to root.
        paths_str = ""
        for p in chunk:
            # escape double quotes in filename
            p_escaped = p.replace('"', '\\"')
            paths_str += f'"{p_escaped}" '
            
        try:
            run(f"git add {paths_str}")
            
            msg = f"Batch upload {i//BATCH_SIZE + 1}: files {i+1} to {i+len(chunk)} of {total}"
            run(f'git commit -m "{msg}"')
            
            run("git push origin main")
            
        except subprocess.CalledProcessError as e:
            print(f"Error in batch {i//BATCH_SIZE + 1}: {e}")
            # If push fails, we stop? Or try to continue? 
            # If commit succeeded but push failed, we are in a state where we have a commit.
            # Next loop will add more and commit on top.
            # But the user wants to push.
            # If push fails, likely temporary or network.
            # We will exit to let user know.
            sys.exit(1)

if __name__ == "__main__":
    main()
