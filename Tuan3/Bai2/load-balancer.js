const http = require("http");

const servers = [
  "http://localhost:3001",
  "http://localhost:3002"
];

let current = 0;

http.createServer((req, res) => {
  const target = servers[current];
  current = (current + 1) % servers.length;

  const proxyReq = http.request(
    target + req.url,
    { method: req.method, headers: req.headers },
    proxyRes => {
      res.writeHead(proxyRes.statusCode, proxyRes.headers);
      proxyRes.pipe(res);
    }
  );

  req.pipe(proxyReq);
}).listen(3000, () => {
  console.log("Load Balancer running on port 3000");
});
