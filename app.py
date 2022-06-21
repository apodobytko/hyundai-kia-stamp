import subprocess

from flask import Flask, jsonify

app = Flask(__name__)


@app.route("/hyundai/<app_id>")
def hyundai(app_id):
    cmd = ["/bin/sh", "lib/exec.sh", "hyundai", "list", app_id]
    result = subprocess.run(cmd, stdout=subprocess.PIPE).stdout.decode("utf-8")
    return jsonify(result.split())


@app.route("/kia/<app_id>")
def kia(app_id):
    cmd = ["/bin/sh", "lib/exec.sh", "kia", "list", app_id]
    result = subprocess.run(cmd, stdout=subprocess.PIPE).stdout.decode("utf-8")
    return jsonify(result.split())


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=81)
