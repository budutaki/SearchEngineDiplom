import java.io.File;
import java.io.IOException;
import java.util.*;

public class BooleanSearchEngine implements SearchEngine {
    //??? мапа

    public BooleanSearchEngine(File pdfsDir) throws IOException {
//
//        Чтобы создать объект пдф-документа, нужно указать объект File
//        этого документа следующим классам: var doc = new PdfDocument(new PdfReader(pdf));.
//        Чтобы получить объект одной страницы документа, нужно вызвать doc.getPage(номерСтраницы).
//        Полистайте методы doc чтобы найти способ узнать количество страниц в документе.
//        Чтобы получить текст со страницы, используйте var text = PdfTextExtractor.getTextFromPage(page);.
//        Чтобы разбить текст на слова (а они в этих документах разделены могут быть не только пробелами),
//        используйте var words = text.split("\\P{IsAlphabetic}+");.
//
//        Сканируя каждый пдф-файл вы перебираете его страницы,
//        для каждой страницы извлекаете из неё слова и подсчитываете их количество.
//        После чего, для каждого уникального слова создаёте объект PageEntry и сохраняете
//        в поле (а что за поле - предлагалось подумать выше).
//        Учтите также, что мы хотим регистронезависимый поиск, т.е. по слову "бизнес"
//        должны учитываться и "бизнес", и "Бизнес" в документах
//        (для этого при обработке достаточно каждое слово переводить в нижний регистр
//        с помощью встроенного метода класса String для этих целей).
//
//          Для подсчёта частоты слов можно использовать следующий приём
//        Map<String, Integer> freqs = new HashMap<>();
//        for (var word : words) {
//            if (word.isEmpty()) {
//                continue;
//            }
//            freqs.put(word.toLowerCase(), freqs.getOrDefault(word.toLowerCase(), 0) + 1);
//        }
//        Также, списки ответов для каждого слова должны быть отсортированы в порядке уменьшения
//        поля count.
//




    }

    @Override
    public List<PageEntry> search(String word) {
        // тут реализуйте поиск по слову
        return Collections.emptyList();
    }
}
