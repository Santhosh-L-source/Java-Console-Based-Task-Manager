# Java Console-Based Task & Habit Manager

A Java console application that allows users to manage tasks with priorities and categories, track daily habits with streaks, and persist all data to plain text files between runs.

## 🎯 Features

- **Add Tasks:** Create tasks with a title, `Priority` enum (`LOW`, `MEDIUM`, `HIGH`), and category.
- **Unique Task IDs:** Automatically generate a unique ID for every task.
- **List & Sort Tasks:** Display incomplete tasks first and completed tasks afterward.
- **Complete Tasks:** Mark tasks as completed using their unique ID.
- **Filter Tasks:** Filter tasks by category or by priority.
- **Habit Tracking & Streaks:** Add habits, mark them done today, and track both `currentStreak` and `longestStreak` using `LocalDate` and `ChronoUnit.DAYS`.
- **File Persistence:** Automatically load tasks (`tasks.txt`) and habits (`habits.txt`) on startup and save on exit using `BufferedReader` and `BufferedWriter`.
- **Error Handling:** Gracefully handle missing/corrupted data files and invalid user inputs without crashing.

## 🛠️ Technologies Used

- Java 21
- `ArrayList` & Java Collections Framework
- `java.time.LocalDate` & `ChronoUnit`
- `BufferedReader` / `BufferedWriter` (File I/O)
- Enums, Composition & Exception Handling (`try/catch`)

## 📁 Project Structure

```text
TaskManager/
│
├── src/
│   ├── Main.java
│   ├── Task.java
│   ├── TaskList.java
│   ├── Priority.java
│   ├── Habit.java
│   ├── HabitTracker.java
│   └── FileStorage.java
│
└── Readme.md
```

## ⚙️ How to Run

### Prerequisites

- Install JDK 21 or later.
- Install IntelliJ IDEA or any Java-supported IDE.

### Step 1: Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### Step 2: Navigate to the Project Directory

```bash
cd TaskManager
```

### Step 3: Compile the Java Files

```bash
javac -d out src/*.java
```

### Step 4: Run the Application

```bash
java -cp out Main
```

## 💻 Application Menu

```text
1. Add Task
2. List Tasks
3. Complete Task
4. Filter Tasks
5. Add Habit
6. Mark Habit Done Today
7. List Habits
8. Exit

Enter the Choice:
```

## 📌 Sample Output

```text
Enter your choice: 1

Enter task title:
Learn Java

Enter priority:
High

Enter your choice: 1

Enter task title:
Learn Spring Boot

Enter priority:
Medium

Enter your choice: 2

========= TASK LIST =========

1 Learn Java High [PENDING]
2 Learn Spring Boot Medium [PENDING]

Enter your choice: 3

Enter the Task ID:
1

Task Completed

Enter your choice: 2

========= TASK LIST =========

2 Learn Spring Boot Medium [PENDING]
1 Learn Java High [DONE]
```

## 📚 Concepts Learned

1. Classes and Objects
2. Constructors and Instance Variables
3. Getters and Setters
4. Encapsulation
5. ArrayList and Collections
6. For-each Loops
7. Conditional Statements
8. Switch Statements
9. Scanner for User Input
10. Comparator and Sorting

## 🚀 Future Improvements

- Add task due dates.
- Filter tasks by priority.
- Delete existing tasks.
- Store tasks permanently using file handling.
- Build a graphical user interface.

## 👨‍💻 Author

**Santhosh L**

Java Developer | Spring Boot | Data Structures & Algorithms

---

*This project was developed as part of my Java learning journey to strengthen my understanding of object-oriented programming and Java collections.*