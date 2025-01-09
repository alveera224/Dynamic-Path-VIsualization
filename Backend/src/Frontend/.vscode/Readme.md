# Dynamic Path Visualization System

A **Dynamic Path Visualization System** that demonstrates the use of **graph algorithms** (e.g., Dijkstra’s algorithm) for finding the shortest path. This project includes a **pure Java backend** and a **vanilla HTML/CSS/JavaScript frontend** for visualization.

---

## 🚀 Features

1. **Add Edges**: Dynamically add edges to the graph with weights.
2. **Shortest Path Calculation**: Uses Dijkstra’s algorithm to find and display the shortest path between two nodes.
3. **Frontend-Backend Interaction**: The frontend communicates with the backend via HTTP requests.
4. **Graph Visualization**: Simple visualization of nodes and paths.

---

## 🛠️ Technology Stack

### Backend:
- **Java**: Core Java for implementing graph data structures and algorithms.
- **HttpServer**: Used to create a lightweight REST-like API.

### Frontend:
- **HTML/CSS**: For the user interface.
- **JavaScript**: To handle user input and interact with the backend.

---

## 📂 Project Structure

dynamic-path-visualization/ ├── backend/ │ ├── src/ │ │ ├── Edge.java # Represents edges in the graph │ │ ├── Graph.java # Implements graph and Dijkstra's algorithm │ │ └── Server.java # HTTP server to handle API requests ├── frontend/ │ ├── index.html # Main HTML file │ ├── styles.css # Styling for visualization │ └── app.js # JavaScript to handle user interaction ├── .vscode/ │ └── launch.json # Debugging configuration └── README.md # Documentation


---

## 🧑‍💻 How to Run

### Prerequisites
1. **Java**: JDK 11 or higher.
2. **VS Code**: With Java Extension Pack and Live Server extension.

### Steps

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/dynamic-path-visualization.git
   cd dynamic-path-visualization
