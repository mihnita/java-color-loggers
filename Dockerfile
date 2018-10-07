FROM maven:3

RUN mkdir /build_dir
WORKDIR /build_dir

COPY . .

CMD ["printenv"]
