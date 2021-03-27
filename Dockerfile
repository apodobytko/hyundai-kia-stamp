FROM adoptopenjdk/openjdk11:alpine

COPY . /workspace
WORKDIR /workspace
ENV BASE_PATH=/workspace

ENTRYPOINT /bin/sh -e $BASE_PATH/lib/exec.sh $0 $1 $2
