package Sudoku.SumsOGroups.Factories.groupFactory.Parse;

import Sudoku.SumsOGroups.Types.GroupCreationStrategy;

import java.util.List;

public record baseGroup(Integer fullValue, Integer size, List<List<Integer>> options) implements GroupCreationStrategy {
}
