package com.atul.scaler.lean.primer.areaunderhills;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

  static Stream<Arguments> argsTestSolve() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, 3}, 6),
        Arguments.of(new int[] {10}, 10),
        Arguments.of(
            new int[] {
              45938332, 56695838, 434610699, 244477852, 442706146, 332835816, 450399266, 228766405,
              202638365, 306607267, 401594990, 430341756, 233848629, 75204867, 354225361, 96541963,
              5672533, 212164013, 78680098, 444857169, 351541353, 122483760, 58319678, 219143217,
              291884722, 55615334, 396837969, 212421501, 373743694, 346524544, 397748501, 63705888,
              355166082, 434650078, 86538054, 371857968, 334862144, 411036383, 91434814, 174635581,
              223951112, 348272869, 138817934, 371010249, 74313343, 432077653, 50046392, 134774168,
              292535717, 432188727, 114296192, 170293994, 229709946, 426896738
            },
            13668143664L));
  }

  @MethodSource("argsTestSolve")
  @ParameterizedTest
  void testSolve(int[] input, long output) {
    assertEquals(String.valueOf(output), new Solution().solve(input));
  }
}
