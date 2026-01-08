#!/bin/bash

# StreamPro Dev Runner - Automation Script
# Principal Engineer: Antigravity

set -e

# --- 1. Environment Setup ---
echo "⚙️  Configuring Environment..."

# Function to find valid JDK 17+
find_java() {
    # Check JAVA_HOME first
    if [[ -n "$JAVA_HOME" && -x "$JAVA_HOME/bin/java" ]]; then
        version=$("$JAVA_HOME/bin/java" -version 2>&1 | awk -F '"' '/version/ {print $2}')
        if [[ "$version" == "17"* || "$version" == "21"* ]]; then
            echo "✅  Using JAVA_HOME: $JAVA_HOME ($version)"
            return 0
        fi
    fi

    # Check Android Studio JBR (Preferred fallback for Android devs)
    AS_JBR="/Applications/Android Studio.app/Contents/jbr/Contents/Home"
    if [[ -d "$AS_JBR" ]]; then
        echo "✅  Found Android Studio JBR. Using it."
        export JAVA_HOME="$AS_JBR"
        return 0
    fi

    # Check Homebrew OpenJDK 17/21
    if [[ -d "/opt/homebrew/opt/openjdk@17" ]]; then
        echo "✅  Found Homebrew OpenJDK 17."
        export JAVA_HOME="/opt/homebrew/opt/openjdk@17"
        return 0
    fi
     if [[ -d "/opt/homebrew/opt/openjdk@21" ]]; then
        echo "✅  Found Homebrew OpenJDK 21."
        export JAVA_HOME="/opt/homebrew/opt/openjdk@21"
        return 0
    fi

    echo "❌  CRITICAL: No suitable JDK 17+ found. Please install JDK 17."
    exit 1
}

find_java

# Ensure gradlew is executable
if [[ ! -x "./gradlew" ]]; then
    echo "⚠️  gradlew not executable. Fixing..."
    chmod +x ./gradlew
fi

# --- 2. Menu ---
show_menu() {
    echo ""
    echo "========================================"
    echo "   StreamPro Dev Runner (Pro Mode) 🚀"
    echo "========================================"
    echo "1. 🧹  Clean Build"
    echo "2. 🧪  Run Unit Tests"
    echo "3. 📱  Check Connected Devices"
    echo "4. 🚀  Install & Launch Debug APK"
    echo "5. 🛠  Full Rebuild (Clean + Install)"
    echo "q. 🚪  Quit"
    echo "========================================"
    read -p "Select an option: " choice
}

# --- 3. Actions ---

clean_build() {
    echo "🧹  Cleaning Project..."
    ./gradlew clean
}

run_tests() {
    echo "🧪  Running Unit Tests..."
    ./gradlew testDebugUnitTest
}

check_devices() {
    echo "📱  Connected ADB Devices:"
    adb devices
}

install_debug() {
    echo "🚀  Building & Installing Debug APK..."
    ./gradlew installDebug
    
    echo "📲  Launching App..."
    adb shell am start -n com.streampro/.MainActivity
}

# --- 4. Main Loop ---
while true; do
    show_menu
    case $choice in
        1) clean_build ;;
        2) run_tests ;;
        3) check_devices ;;
        4) install_debug ;;
        5) clean_build && install_debug ;;
        q) echo "👋  Exiting..."; exit 0 ;;
        *) echo "❌  Invalid option." ;;
    esac
    echo ""
    read -p "Press Enter to continue..."
done
