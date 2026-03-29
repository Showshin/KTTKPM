import express from 'express';

const app = express();
const PORT = process.env.PORT || 3000;

app.get('/', (req, res) => {
  res.send('<h1>Welcome to My Express App</h1><p>Visit <a href="/about">/about</a> or <a href="/time">/time</a></p>');
});

app.get('/about', (req, res) => {
  res.json({ name: 'my-express-app', version: '1.0.0', author: 'Student' });
});

app.get('/time', (req, res) => {
  res.json({ time: new Date().toISOString() });
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
