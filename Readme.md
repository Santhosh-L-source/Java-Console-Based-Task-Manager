# Java Console-Based Task Manager

A beginner-friendly Java console application that allows users to add, view, and complete tasks. This project demonstrates fundamental Java concepts, including Object-Oriented Programming (OOP), ArrayList, constructors, methods, loops, and conditional statements.

## 🎯 Features

- **Add Tasks:** Create tasks with a title and priority.
- **Unique Task IDs:** Automatically generate a unique ID for every task.
- **List Tasks:** Display all available tasks with their details.
- **Complete Tasks:** Mark tasks as completed using their unique ID.
- **Task Status:** Display tasks as `[PENDING]` or `[DONE]`.
- **Sorting:** Display incomplete tasks first and completed tasks afterward.
- **Error Handling:** Handle invalid task IDs and attempts to complete an already completed task.
- **Interactive Menu:** Continue performing operations until the user chooses to exit.

## 🛠️ Technologies Used

- Java 21
- ArrayList
- Scanner
- Object-Oriented Programming (OOP)
- Java Collections Framework

## 📁 Project Structure

```text
TaskManager/
│
├── src/
│   ├── Task.java
│   ├── TaskList.java
│   └── Main.java
│
└── README.md
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
========== TASK MANAGER ==========

1. Add Task
2. List Tasks
3. Complete Task
4. Exit

Enter your choice:
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
