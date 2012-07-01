import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.klomp.snark.bencode.BDecoder;
import org.klomp.snark.bencode.BEValue;


public class DecoderTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BDecoder decoder = new BDecoder(new FileInputStream(new File("src/test/resources/Lockout.2012.720p.BRRip.XviD.AC3-Voltage.torrent")));
		BEValue bdecode = decoder.bdecode();
		Map map = bdecode.getMap();
		BEValue info = (BEValue) map.get("info");
		Map mapInfo = info.getMap();
		BEValue files = (BEValue) mapInfo.get("files");
		List list = files.getList();
		for (Object object : list) {
			BEValue file = (BEValue) object;
			Map map2 = file.getMap();
			BEValue object2 = (BEValue) map2.get("path");
			List list2 = object2.getList();
			String path = ((BEValue)list2.get(0)).getString();
			System.out.println(path);
		}
	}

}
