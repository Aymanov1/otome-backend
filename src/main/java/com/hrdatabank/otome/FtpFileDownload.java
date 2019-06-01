//package com.hrdatabank.otome;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;
//
//public class FtpFileDownload {
//	private static Logger log = LoggerFactory.getLogger(FtpFileDownload.class);
//
//	public static void main(String args[]) throws IOException {
//
//		downloadFromServer("54.199.180.213", "saintmedia", "JQg9VXVxk649", 38862, "/data/lacotto_job_offer.zip",
//				"/home/aymen/Téléchargements/lacotto_job_offer.zip");
//
//	}
//
//	private static void downloadFromServer(String host, String user, String password, int port, String pathRemote,
//			String pathLocal) {
//		JSch jsch = new JSch();
//		Session session = null;
//		try {
//			session = jsch.getSession(user, host, port);
//			session.setConfig("StrictHostKeyChecking", "no");
//			session.setPassword(password);
//			session.connect();
//
//			Channel channel = session.openChannel("sftp");
//			channel.connect();
//			ChannelSftp sftpChannel = (ChannelSftp) channel;
//			sftpChannel.get(pathRemote, pathLocal);
//			log.info("download done successfully!!!");
//			sftpChannel.exit();
//			
//			session.disconnect();
//		} catch (JSchException e) {
//			e.printStackTrace();
//		} catch (SftpException e) {
//			e.printStackTrace();
//		}
//	}
//
//}