package oleksii.filonov.interview.tasks.string;


import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegExpsTest {

    private RegExps electronicsPatterns;

    private RegExps marketplacePatterns;

    @BeforeEach
    public void setUp() {
        electronicsPatterns = new RegExps(List.of("(?i)^https?://[^/]+(/[^?]*)?\\?(.*\\&)?(site=electronics)(|\\&.*)$",
                "(?i)^https?://electronics\\.[^/]+(|/.*|\\?.*)$", "(?i)^https?://[^/]+(/[^?]*)?/sparkstorefront[/]?$",
                "(?i)^https?://[^/]+(/[^?]*)?/electronics.*$",
                "(?i)^https?://[^/]+(/[^?]*)?/sparkstorefront/\\?(?!site=).*$"));
        marketplacePatterns = new RegExps(List.of("(?i)^https?://[^/]+(/[^?]*)?\\?(.*\\&)?(site=marketplace)(|\\&.*)$",
                "(?i)^https?://marketplace\\.[^/]+(|/.*|\\?.*)$",
                "(?i)^https?://api\\.hybrisdev\\.com(:[\\d]+)?/rest/.*$",
                "(?i)^https?://localhost(:[\\d]+)?/rest/.*$"));
    }

    @Test
    public void shouldFindElectronicsStore() {
        var electronicsUrls = List.of("https://localhost:9002/sparkstorefront/?site=electronics",
                "http://electronics.local:9002/",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/?site=electronics",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/?parameter=value",
                "https://hybris.local:9002/sparkstorefront/", "https://localhost:9002/sparkstorefront/",
                "https://localhost:9002/sparkstorefront",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/electronics/en/login");
        shouldMatchUrls(electronicsPatterns, electronicsUrls);
        shouldNotMatch(marketplacePatterns, electronicsUrls);
    }

    @Test
    public void shouldFindMarketplaceStore() {
        var marketplaceUrls = List.of(
                "https://localhost:9002/sparkstorefront/?site=marketplace&something=sdf&sdfsdf=sdfsd",
                "http://marketplace.local:9002/", "http://localhost:9002/rest/", "http://api.hybrisdev.com:9002/rest/",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/?site=marketplace");
        shouldMatchUrls(marketplacePatterns, marketplaceUrls);
        shouldNotMatch(electronicsPatterns, marketplaceUrls);
    }

    @Test
    public void shouldFindNoneStore() {
        var marketplaceUrls = List.of("https://localhost:9002/sparkstorefront/?site=another",
                "http://somestore.local:9002/", "http://localhost:9002/webRoot/",
                "https://qa2-front-1.epmd-dspk.projects.epam.com:9002/sparkstorefront/?site=another&param=valuet");
        shouldNotMatch(marketplacePatterns, marketplaceUrls);
        shouldNotMatch(electronicsPatterns, marketplaceUrls);
    }

    @Test
    public void noMatch() throws Exception {
        assertFalse(Pattern.matches("^abc/\\?(.*\\&)*(?!bla=)(|\\&.*)*$", "abc/?bla=bla"));
        assertFalse(Pattern.matches("^abc/\\?(?!bla=).*$", "abc/?bla=herewego"));
        assertTrue(Pattern.matches("^abc/\\?(?!bla=).*$", "abc/?bal=bla"));
        assertTrue(Pattern.matches("^abc/\\?(?!bla=).*$", "abc/?some=bla"));
        assertTrue(Pattern.matches("^abc/\\?(.*\\&)*(?!bla=).*$", "abc/?param=baran"));
        assertFalse(Pattern.matches("https://localhost:9002/sparkstorefront/\\?(?!site=).*$",
                "https://localhost:9002/sparkstorefront/?site=mrketplace&something=sdf&sdfsdf=sdfsd"));
        assertFalse(Pattern.matches("^.*\\&(\\?!site).*$",
                "https://localhost:9002/sparkstorefront/?something=sdf&sdfsdf=sdfsd&site=mrketplace"));
        assertFalse(Pattern.matches("^abc/\\?(.*\\&)*(?!bla=)(|\\&.*)*$", "abc/?bla=bla&param=value"));
        assertFalse(Pattern.matches("^abc/\\?(.*\\&)*(?!bla=)(|\\&.*)*$", "abc/?param=value&bla=blat"));
    }

    private void shouldNotMatch(RegExps patterns, List<String> urls) {
        for (String url : urls) {
            assertFalse(patterns.matches(url), url + " should not match this pattern");
        }
    }

    private void shouldMatchUrls(RegExps patterns, List<String> urls) {
        for (String url : urls) {
            assertTrue(patterns.matches(url), url + " doesn't match to pattern");
        }
    }

    @Test
    public void addOnMatcher() {
        Pattern addonPattern = Pattern.compile("^(pages/|)addon:/(\\w+?)/");
        assertTrue(addonPattern.matcher(
                "pages/addon:/sparkb2cintegrationsaddon/responsive/pages/checkout/multi/sparkChooseRedirectPaymentDetailsPage")
                .find());
    }

}
