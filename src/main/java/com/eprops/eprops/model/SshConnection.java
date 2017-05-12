package com.eprops.eprops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SshConnection {
    private SSHClient sshClient;
    private Session session;
}
