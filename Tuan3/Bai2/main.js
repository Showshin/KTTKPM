const express = require("express");
const app = express();

const PORT = process.env.PORT || 3001;

app.get("/hello", (req, res) => {
  res.send(`Hello from server ${PORT}`);
});

app.listen(PORT, () => {
  console.log(`App running on port ${PORT}`);
});
