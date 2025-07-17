# Java RMI Client-Server Program

This is a Java-based client-server system using **Java RMI (Remote Method Invocation)**. It demonstrates remote communication, object-oriented programming, and database interaction with **PostgreSQL**.

---

## 📁 Project Structure

<pre> <code> client-server-program/ ├── ClientProgram/ │ ├── src/ │ ├── dist/ │ └── nbproject/ └── ServerProgram/ ├── src/ ├── dist/ └── nbproject/ </code> </pre>


---

## 🎯 Features

### 🖥️ ServerProgram
- Hosts the RMI server and registers remote objects.
- Implements remote methods in `StudentDBImpl.java`.
- Handles client requests and interacts with PostgreSQL.

### 💻 ClientProgram
- Connects to server via RMI.
- GUI-based interface for operations (`GUIOne.java`).
- Uses helper classes to access and manipulate data.

---

## ⚙️ Technologies Used

- Java SE (JDK)
- Java RMI
- PostgreSQL
- NetBeans (with `nbproject`)
- JDBC driver
- Object-Oriented Design

---

## 🚀 How to Run (For Future Setup)


### Prerequisites:
- Java installed
- PostgreSQL running
- Tables configured as expected in the DB
- RMI registry available

### Server:
```bash
cd ServerProgram
java -cp "dist/ServerProgram.jar" RMI.StudentRMIServer
