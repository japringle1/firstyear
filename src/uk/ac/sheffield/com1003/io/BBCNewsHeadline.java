package uk.ac.sheffield.com1003.io;

import java.io.IOException;

public class BBCNewsHeadline {

	public static void main(String[] args) {

		try {
			String contents = URLDownloader
					.urlContents("http://news.bbc.co.uk");

			String topStory = contents.substring(contents
					.indexOf("<div id=\"top-story\""));
			String link = topStory.substring(topStory
					.indexOf("<a class=\"story\"") + 1);
			String headline = link.substring(link.indexOf(">") + 1,
					link.indexOf("<"));

			System.out.println("The current BBC news headline is: \""
					+ headline + "\"");

		} catch (IOException e) {
			System.out.println("There was an error: " + e.getMessage());
		}
	}
}
