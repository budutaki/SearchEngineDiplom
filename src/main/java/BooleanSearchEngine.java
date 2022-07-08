import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BooleanSearchEngine implements SearchEngine {
    public Map<String, List<PageEntry>> index;

    public BooleanSearchEngine(File pdfsDir) throws IOException {
        index = new HashMap<>();
        index(pdfsDir);
    }

    private Map<String, List<PageEntry>> index(File pdfsDir) throws IOException {
        File[] pdfs = pdfsDir.listFiles();
        for (File pdf : pdfs) {
            var doc = new PdfDocument(new PdfReader(pdf));
            for (int i = 0; i < doc.getNumberOfPages(); i++) {
                PdfPage page = doc.getPage(i + 1);
                var text = PdfTextExtractor.getTextFromPage(page);
                var words = text.split("\\P{IsAlphabetic}+");

                Map<String, Integer> freqs = getWordFrequency(words);

                for (Map.Entry<String, Integer> entries : freqs.entrySet()) {
                    PageEntry entry = new PageEntry(pdf.getName(), doc.getPageNumber(page), entries.getValue());
                    if (index.containsKey(entries.getKey())) {
                        index.get(entries.getKey()).add(entry);
                    } else {
                        List<PageEntry> pageEntryList = new ArrayList<>();
                        pageEntryList.add(entry);
                        index.put(entries.getKey(), pageEntryList);
                    }
                }
            }
        }
        return index;
    }


    private Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> freqs = new HashMap<>();
        for (var word : words) {
            if (word.isEmpty()) {
                continue;
            }
            freqs.put(word.toLowerCase(), freqs.getOrDefault(word.toLowerCase(), 0) + 1);
        }
        return freqs;
    }

    @Override
    public List<PageEntry> search(String word) {
        List<PageEntry> result = index.get(word);
        Collections.sort(result);
        return result;
    }
}
