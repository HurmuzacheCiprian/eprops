package com.eprops.eprops.service;

import com.eprops.eprops.model.SshCommand;
import com.eprops.eprops.util.SshResultToPropertyFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Properties;

@RunWith(MockitoJUnitRunner.class)
public class SshServiceTest {

    private SshCommandRunner sshCommandRunner = Mockito.mock(SshCommandRunner.class);

    private SshResultToPropertyFile sshResultToPropertyFile = new SshResultToPropertyFile();

    private SshService sshService;

    @Before
    public void init() {
        sshService = new SshService(sshCommandRunner, sshResultToPropertyFile);
    }

    @Test
    public void test() {
        final String result = "#ADM Service Environment Property File\n" +
                "#Wed May 10 15:09:08 BST 2017\n" +
                "adobe.wsdl.address=https\\://skyuk-rt-dev2.campaign.adobe.com/nl/jsp/soaprouter.jsp\n" +
                "op-rabbit.connection.virtual-host=int.oogway.id.bskyb.com\n" +
                "op-rabbit.connection.username=oogwayadmin\n" +
                "op-rabbit.connection.hosts.0=e05imq01.int.oogway.id.bskyb.com\n" +
                "username=depogwint\n" +
                "servers=[e05adm01.dev.oogway.id.bskyb.com, e05adm02.dev.oogway.id.bskyb.com]\n" +
                "adobe.username=mc\n" +
                "op-rabbit.connection.port=5672";
        SshCommand sshCommand = new SshCommand("c", "e", "u", "p");

        Mockito.when(sshCommandRunner.executeCommand(Mockito.any())).thenReturn(result);
        Properties propertyFile = sshService.readPropertiesFile(sshCommand);

        Assert.assertTrue(propertyFile.size() == 8);
        Assert.assertTrue("oogwayadmin".equals(propertyFile.getProperty("op-rabbit.connection.username")));
        Assert.assertTrue("5672".equals(propertyFile.getProperty("op-rabbit.connection.port")));
    }

}
