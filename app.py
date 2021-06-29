import subprocess

from flask import Flask

app = Flask(__name__)


@app.route("/hyundai")
def hyundai():
    cmd = ["/bin/sh", "lib/exec.sh", "hyundai", "single", "99cfff84-f4e2-4be8-a5ed-e5b755eb6581"]
    return subprocess.run(cmd, stdout=subprocess.PIPE).stdout.decode("utf-8")


@app.route("/kia")
def kia():
    cmd = ["/bin/sh", "lib/exec.sh", "kia", "single", "693a33fa-c117-43f2-ae3b-61a02d24f417"]
    return subprocess.run(cmd, stdout=subprocess.PIPE).stdout.decode("utf-8")


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=81)
