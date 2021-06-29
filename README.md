# hyundai-kia-stamp

This is me trying to put together the stamp generation in a docker container for convenience. Since the binaries are extracted from android you need to run them on linux so using docker is a rather easy way to make this easier.

All the hard work goes credit to [@neoPix](https://github.com/neoPix)


### Usage

Run this to start flask app

```
make build ; docker run -p 81:81 -d hacksore/hks:local
```

Examples:

```
curl localhost:81/kia
curl localhost:81/hyundai
```
