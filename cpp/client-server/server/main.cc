#include <iostream>
#include <errno.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/fcntl.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>

#define SERVER_PORT 12345 /* arbitrary, but client & server must agree */
#define BUF_SIZE 4096 /* block transfer size */
#define QUEUE_SIZE 10

void fatal(const char *string) {
    printf("%s\n", string); 
    exit(1);
}

int main(int argc, char *argv[]) {
    int s, b, l, fd, sa, bytes, on = 1;
    char buf[BUF_SIZE];  /* buffer for outgoing file */
    struct sockaddr_in channel;  /* holds IP address */
    
    
    /* Build address structure to bind to socket. */
    memset(&channel, 0, sizeof(channel));
    channel.sin_family = AF_INET;
    channel.sin_addr.s_addr = htonl(INADDR_ANY);
    channel.sin_port = htons(SERVER_PORT);

    /* Passive open. Wait for connection. */
    s = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (s < 0) fatal("socket failed");

    setsockopt(s, SOL_SOCKET, SO_REUSEADDR, (char *) &on, sizeof(on));

    b = bind(s, (struct sockaddr *) &channel, sizeof(channel));
    if (b < 0) fatal("bind failed");

    l = listen(s, QUEUE_SIZE); /* specify queue size */
    if (l < 0) fatal("listen failed");
    
    /* Socket is now set up and bound. Wait for connection and process it. */
    while (1) {
        sa = accept(s, 0, 0);
        if (sa < 0) fatal("accept failed");
        
        read(sa, buf, BUF_SIZE);
        /* Get and return the file. */
        fd = open(buf, O_RDONLY);
        if (fd < 0) {
            printf("open failed\n");
        }

        while (1) {
            bytes = read(fd, buf, BUF_SIZE); /* read from file */
            if (bytes <= 0) break;
            write(sa, buf, bytes);
        }
        close(fd);
        close(sa);
    }
}