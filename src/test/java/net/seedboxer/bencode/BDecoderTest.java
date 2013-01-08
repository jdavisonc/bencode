package net.seedboxer.bencode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.junit.Test;

public class BDecoderTest {

	@Test
	public void shouldReadRealTorrentFile() throws IOException {

		BDecoder decoder = new BDecoder();
		Map bdecode = decoder.decodeStream(new BufferedInputStream( new FileInputStream(new File("src/test/resources/Lockout.UNRATED.720p.BluRay.X264-BLOW.torrent"))));

		System.out.println(bdecode);

		Map map = (Map) bdecode.get("info");
		System.out.println(map);
		System.out.println(new String((byte[]) map.get("name")));

	}

}
