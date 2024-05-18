FROM ubuntu:latest
COPY src /src
CMD ubuntu /src
LABEL authors="WuHaoxiang"

ENTRYPOINT ["top", "-b"]