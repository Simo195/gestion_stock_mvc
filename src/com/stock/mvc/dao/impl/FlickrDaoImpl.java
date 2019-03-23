package com.stock.mvc.dao.impl;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.stock.mvc.dao.IFlickrDao;


public class FlickrDaoImpl implements IFlickrDao {

	private Flickr flickr;
	
	private UploadMetaData UploadMetaData = new UploadMetaData();
	
	private String apiKey = "df766f377ed606f3fc4a1a6e1817468e";
	
	private String sharedSecret = "d23489fac537dd40";
	
	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157678731273846-45f683ca35c4b3c2");
		auth.setTokenSecret("6342826986448e45");
		
		RequestContext requestContext = RequestContext.getRequestContext();
		flickr.setAuth(auth);
	}
	
	
	@Override
	public String savePhoto(InputStream photo, String Title) throws Exception {
		connect();
		UploadMetaData.setTitle(Title);
		String photoId = flickr.getUploader().upload(photo, UploadMetaData);
		
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	public void auth() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		AuthInterface authInterface = flickr.getAuthInterface();
		
		Token token = authInterface.getRequestToken();
		System.out.println("token: " + token);
		String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
		System.out.println("Follow this URL to authorise yourself on Flickr");
		System.out.println(url);
		System.out.println("Paste in the token it gives you:");
		System.out.println(">>");
		
		String tokenKey = JOptionPane.showInputDialog(null);
		
		Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));

		System.out.println("Authentification success");
		
		Auth auth = null;
		
		try {
			
			auth = authInterface.checkToken(requestToken);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		
		System.out.println("Token:" + requestToken.getToken());
		System.out.println("Secret:" + requestToken.getSecret());
		System.out.println("nsid:" + auth.getUser().getId());
		System.out.println("Realname:" + auth.getUser().getRealName());
		System.out.println("Username:" + auth.getUser().getUsername());
		System.out.println("Permission:" + auth.getPermission().getType());
		
		
		
	}


}
