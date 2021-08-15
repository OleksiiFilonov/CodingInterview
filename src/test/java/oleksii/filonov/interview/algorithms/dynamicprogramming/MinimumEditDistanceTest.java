package oleksii.filonov.interview.algorithms.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumEditDistanceTest {

    private MinimumEditDistance minimumEditDistance = new MinimumEditDistance();

    @Test
    public void smallWordsRecursion() {
        assertEquals(6, minimumEditDistance.recursion("ilani", "jtimke"));
        assertEquals(3, minimumEditDistance.recursion("horse", "ros"));
        assertEquals(5, minimumEditDistance.recursion("intention", "execution"));
        assertEquals(5, minimumEditDistance.recursion("pizza", "yolo"));
    }

    @Test
    public void smallWordsDP() {
        assertEquals(6, minimumEditDistance.dp("ilani", "jtimke"));
        assertEquals(3, minimumEditDistance.dp("horse", "ros"));
        assertEquals(5, minimumEditDistance.dp("intention", "execution"));
        assertEquals(5, minimumEditDistance.dp("pizza", "yolo"));
    }

    @Test
    public void bigWords() {
        assertEquals(17, minimumEditDistance.dp("masilanidbny", "zwujtimkexcgvxrgkp"));
        assertEquals(6, minimumEditDistance.dp("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        assertEquals(17, minimumEditDistance.dp("masilanidbny", "zwujtimkexcgvxrgkp"));
    }

    @Test
    public void megaBigWords() {
        assertEquals(890, minimumEditDistance.dp("lfxvyyrocemqverqpxunnqnmzzcfgcwwndtecqshtvuryeybcgguscieumundobaqbqagcyfelzimlyyuyslimyubqcdrpihmpffugrqareicejczftutexbtufwtkchxzdkgfffkfrwfvehmznzysbmuhivsypvsilklpqdkkvcbadsckberssneuvmsjysitefhsolddkpekeovcqziecnerigvpqkikmlsntnlfjpadjcocrwqrtvlycvyipwygldhgxksmeqefdxqbuvbbtgbnzqnaiyeumbnzyemuwhkfgsvbrptgkliuxjeogszffrarojiuoshbxghptwwlkmomndgyrmahcraoxbhotwkvwrtjxouolojidliezomvcbkspkoaukocdmhqmxnmvszichkjsptytnjcgneoolkqkyghlxadkfrhkxspwxvaojhssavrambzpbvvsrtpxysvzqfmjrlskwgiammacvrbfewhrjmwuhajmuvbvqlbqqfsoydkbtkbkpshhxjocbxurdribfuhphgjnrhpzsfonlbbpldgbffxqzkveltbedvohvrwncdxwckaojxpoiopyuidqmmesqxupfvevvcenkikospvpheimmhiitusgffnnbnpsispnwxrcieaqiyydpjeabtejyludrmyctzmeuvvrhaczykqsczuqlcbknleznlochmsdtrrmltfzvvztnzifoqagmjfledsofmanfagbsaahnmqlmzolevbeisbnaagjwdxmwinnzinsivgckitrczzxltttkqyerrfppywgqhtbijznsjttvbvlygivuoywidktsbktdfwoivookvyrswpjufetuddmyusssjmrwfodojqobfwpkquhzddzzvltrslstswcbdwqlxrzvfohnsfyvydlvsiidvsjmdtewnccwiwminqbkocktogyfwlgwtztcxaoxaagdrablxmjmviwrbest", "fpohpktrkdorhuqdyxxsbppwokdtzhkwvzckiiqgjtuooubixgfbgzqzvgkvykghhfplakumihjyxpdifgswscecbxgvhxtufkhsfcwksnfqmumqtxvbmtieayqqiltwydftdhxhicvycvbnvelmaowtyttkfgkyxgjdpuxfgpriggcpimhjqhbyitusemkzewqcqwhjximqapymljofxdfyndynytlgwkggidhbdamsgczgsivovkxdaxwkuzhrsvitmvpfcwewhaxmpclgrywylkvyekkxidaxewbwzztuudgxfjdpghgoalvfxwwueebskklxxdkznzgxpezwjwgeabtcdkjaxfuyncqygbgpuzxghssftjdbodntatpjopiixlokbywmvjasmrccfqfqdrcubjcjjjimxbsuluvwnwhobgqzjywulfoaquubumvscmfbagkjnulvumaynrzrqsufcprzaqsjncfavnqchjshdibqdmhqpptymnwooitknthiqlqxplembdynjrwwwhaksonvzlpfdkdnjdvggsydtzcgjwaoybzdcxvlnlojnbjicottvlosvqazjhjvozkxmlefivbmxudedkpicxnlihheyyybulcftvxvrwkpbwwmemrkhkszvzutsalbbcshbpumrkqwflkrarezsghmexevfsxcxnmpitlvcmbepsuhyecjqtbhhuehkugdlhqvcjmqujmctzahlfigilbyxwnzlzvfedjtpkfylfhgpwpqhrheszjwzvsvssqwghshbakpvhfkupfjcgckondmdwdhhabpbwurxjpomgrxliedktqkkwaeubzlahknivnyjaolfxcbrakqcvmaxylpwieohdtdwioidvtilghxrefvredcutmhbrfgxywsxalbaoicpwprsuvhsgcqpohuljkhantsoezeeuvzjctjuowxdhyujhwsyhmhioamzukhdnzsjkgpoqyw"));
    }

}