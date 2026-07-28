FROM ubuntu:latest
LABEL authors="programmer"

ENTRYPOINT ["top", "-b"]