# Task Management System

A lightweight, console-driven Java application built to manage daily tasks efficiently. The project leverages Object-Oriented Programming (OOP) design patterns, robust file I/O operations, and state serialization to ensure user tasks are securely saved and loaded between application sessions.

## 🔑 Key Features

* **Task Management (CRUD):** Easily add, view, and remove tasks using structured data parameters (Task Name, Unique ID, and Description).
* **Data Persistence:** Implements Java's `Serializable` interface via `ObjectOutputStream` and `ObjectInputStream` to save data to a binary file (`tasks.dat`).
* **Fail-Safe State Preservation:** Uses a Java `Runtime` shutdown hook to auto-save the task cache in case the application closes unexpectedly.
* **ID Collision Prevention:** Validates incoming task entries against existing data structures to prevent duplicate IDs.
* **Text-Based User Interface:** Provides a simple `Scanner`-based command-line interface for intuitive navigation.
