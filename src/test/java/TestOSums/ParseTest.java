package TestOSums;

import Sudoku.SumsOGroups.POJO.Group;
import Sudoku.SumsOGroups.Factories.groupFactory.Parse.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseTest {
    @Test
    @DisplayName("Basic Parse")
    public void parse() {
        Parser parser = new Parser();
        Group gp = parser.parse();
        assert gp != null;
        gp.validate();
        System.out.println(gp);
        assertEquals(Set.of(3,1), gp.getValidValues());
    }
}
