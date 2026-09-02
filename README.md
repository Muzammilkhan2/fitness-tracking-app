# Fitness Tracker App

A comprehensive Android application built with Kotlin and XML to help users track their daily fitness activities, including steps, calories, water intake, workouts, and sleep.

## 🚀 Features

### Core Functionality
*   **User Authentication**: Secure Login and Signup system using SQLite database.
    *   Session Management: Remembers logged-in users using SharedPreferences.
    *   Forgot Password: Placeholder link for password recovery.
*   **Dashboard (Home)**: View daily progress at a glance.
    *   Interactive stat cards for **Steps**, **Calories**, **Water**, and **Workout**.
    *   **New**: Added a **Sleep Hours** card to track rest.
    *   Quick actions: Log water intake and start workouts directly from the home screen.
*   **Notifications (Alerts)**:
    *   Stay motivated with system alerts for goals reached, hydration reminders, and workout suggestions.
    *   **New**: Alerts tab now features a notification badge/count.
*   **Profile Management**:
    *   View account details.
    *   **New**: Fully editable profile—update your name and email directly in the app.
    *   Secure Logout with a confirmation dialog.

## 🛠️ Tech Stack
*   **Language**: Kotlin
*   **UI Layout**: XML (Material Design)
*   **Database**: SQLite (Local storage for users)
*   **Architecture**: Fragment-based navigation with a BottomNavigationView.
*   **Compatibility**: Min SDK 24, Target SDK 35.

## 📋 Setup Instructions
1.  **Clone the repository**:
    ```bash
    git clone https://github.com/Muzammilkhan2/fitness-tracking-app.git
    ```
2.  **Open in Android Studio**:
    *   File > Open > Select the project folder.
3.  **Sync Gradle**:
    *   Wait for Android Studio to finish the Gradle sync process.
4.  **Build and Run**:
    *   Select an emulator or physical device and click the **Run** button.

## 📱 App Flow
1.  **Login/Signup**: New users can register; existing users log in to their personalized dashboard.
2.  **Home**: View and update your fitness stats.
3.  **Alerts**: Check for reminders and achievement notifications.
4.  **Profile**: Manage your account or logout.

---
*Developed as part of a Fitness Tracker Android Project.*
