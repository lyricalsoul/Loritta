FROM gitpod/workspace-postgresql

USER gitpod

RUN sudo install-packages pngquant gifsicle

RUN sdk install java 18.0.1-tem
RUN sdk default java 18.0.1-tem
