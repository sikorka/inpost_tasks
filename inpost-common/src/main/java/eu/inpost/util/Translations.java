package eu.inpost.util;

import eu.inpost.util.data.TranslationsData;
import eu.inpost.util.json.JsonReaderWriter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Translations {
    private TranslationsData translationsData;

    private static Translations translations = new Translations();

    private Translations() {
        log.debug("Reading translations file...");
        String translationsString = ResourceFileReader.getSmallFileContentFromResources("translations.json");
        translationsData = JsonReaderWriter.fromJson(translationsString, TranslationsData.class);
        log.debug("Reading translations file done.");

        log.info(translationsData);
    }

    public static TranslationsData.Language getTranslations() {
        switch (Environment.getLang()) {
            case "PL" : return translations.translationsData.getPL();
            case "EN" : return translations.translationsData.getEN();
            default : {
                log.error("No translation found for language " + Environment.getLang() + "!");

                return null;
            }
        }
    }
}
