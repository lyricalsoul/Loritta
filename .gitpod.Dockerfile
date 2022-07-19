FROM gitpod/workspace-postgresql

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 18.0.1-tem && \
    sdk default java 18.0.1-tem"
