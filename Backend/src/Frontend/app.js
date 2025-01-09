document.getElementById("addEdgeForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const source = document.getElementById("source").value;
    const destination = document.getElementById("destination").value;
    const weight = document.getElementById("weight").value;

    await fetch("http://localhost:8080/add-edge", {
        method: "POST",
        headers: { "Content-Type": "application/x-www-form-urlencoded" },
        body: `source=${source}&destination=${destination}&weight=${weight}`,
    });

    alert("Edge added successfully!");
});

document.getElementById("shortestPathForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const start = document.getElementById("start").value;
    const end = document.getElementById("end").value;

    const response = await fetch(`http://localhost:8080/shortest-path?start=${start}&end=${end}`);
    const result = await response.text();

    document.getElementById("result").innerText = result;
});
