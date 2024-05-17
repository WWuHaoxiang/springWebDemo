FROM ubuntu:latest
COPY src /src
CMD ubuntu /src
LABEL authors="Chennian"

ENTRYPOINT ["top", "-b"]