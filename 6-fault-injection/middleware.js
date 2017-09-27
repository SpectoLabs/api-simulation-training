#!/usr/bin/env node

process.stdin.resume();
process.stdin.setEncoding('utf8');
process.stdin.on('data', function(data) {
  var parsed_json = JSON.parse(data);
  parsed_json.response.status = 200;
  parsed_json.response.body = JSON.stringify([
    {
      "origin": "Mars",
      "destination": "Pluto",
      "cost": "9999.99",
      "when": "00:00"
    }
  ]);

  process.stdout.write(JSON.stringify(parsed_json));
});
