package me.blvckbytes.segmentstates

import java.util.EnumSet

enum class SegmentState(
  private val character: Char,
  val segments: EnumSet<Segment>
) {

  SPACE(' '),

  /*
      |
      |
       .
   */
  BANG('!', Segment.C, Segment.D, Segment.DP),

  /*
    | |
   */
  DOUBLE_QUOTES('"', Segment.H, Segment.J),

  /*
      | |
     - -
      | |
     - -
   */
  HASHTAG('#', Segment.C, Segment.D, Segment.E, Segment.F, Segment.P, Segment.L, Segment.J, Segment.N),

  /*
     - -
    | |
     - -
      | |
     - -
   */
  DOLLAR('$', Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.H, Segment.P, Segment.L, Segment.J, Segment.N),

  /*
     -
    | |/
     - -
     /| |
       -
   */
  PERCENT('%', Segment.P, Segment.L, Segment.J, Segment.N, Segment.K, Segment.O, Segment.A, Segment.D, Segment.E, Segment.H),

  /*
     -
     \|
     -
    |  \
     - -
   */
  AMPERSAND('&', Segment.A, Segment.E, Segment.F, Segment.G, Segment.J, Segment.P, Segment.I, Segment.M),

  /*
    |
   */
  SINGLE_QUOTE('\'', Segment.H),

  /*
     /
     \
   */
  PAREN_OPEN('(', Segment.K, Segment.M),

  /*
     \
     /
   */
  PAREN_CLOSE(')', Segment.I, Segment.O),

  /*
     \|/
     - -
     /|\
   */
  STAR('*', Segment.P, Segment.L, Segment.J, Segment.N, Segment.I, Segment.K, Segment.O, Segment.M),

  /*
      |
     - -
      |
   */
  PLUS('+', Segment.P, Segment.L, Segment.J, Segment.N),

  /*
     /
   */
  COMMA(',', Segment.O),

  /*
     - -
   */
  MINUS('-', Segment.P, Segment.L),

  /*
    .
   */
  DOT('.', Segment.DP),

  /*
       /
     /
   */
  SLASH('/', Segment.O, Segment.K),

  /*
     - -
    |  /|
    |/  |
     - -
   */
  ZERO('0', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H, Segment.K, Segment.O),

  /*
    |
    |
   */
  ONE('1', Segment.C, Segment.D),

  /*
     - -
        |
     - -
    |
     - -
   */
  TWO('2', Segment.A, Segment.B, Segment.C, Segment.E, Segment.F, Segment.G, Segment.P, Segment.L),

  /*
     - -
        |
       -
        |
     - -
   */
  THREE('3', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.L),

  /*
    |   |
     - -
        |
   */
  FOUR('4', Segment.C, Segment.D, Segment.H, Segment.P, Segment.L),

  /*
     - -
    |
     - -
        |
     - -
   */
  FIVE('5', Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.H, Segment.P, Segment.L),

  /*
     - -
    |
     - -
    |   |
     - -
   */
  SIX('6', Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H, Segment.P, Segment.L),

  /*
     - -
        |
        |
   */
  SEVEN('7', Segment.A, Segment.B, Segment.C, Segment.D),

  /*
     - -
    |   |
     - -
    |   |
     - -
   */
  EIGHT('8', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H, Segment.P, Segment.L),

  /*
     - -
    |   |
     - -
        |
     - -
   */
  NINE('9', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.H, Segment.P, Segment.L),

  /*
    |
    |
   */
  COLON(':', Segment.J, Segment.N),

  /*
    |
    /
   */
  SEMICOLON(';', Segment.J, Segment.O),

  /*
      /
     -
      \
   */
  LESS('<', Segment.K, Segment.M, Segment.P),

  /*
     - -
     - -
   */
  EQUALS('=', Segment.P, Segment.L, Segment.F, Segment.E),

  /*
      \
       -
      /
   */
  GREATER('>', Segment.I, Segment.L, Segment.O),

  /*
     - -
        |
       -
      |
       .
   */
  QUESTION_MARK('?', Segment.A, Segment.B, Segment.C, Segment.L, Segment.N, Segment.DP),

  /*
     - -
    | | |
       -
    |
     - -
   */
  AT('@', Segment.A, Segment.B, Segment.C, Segment.E, Segment.F, Segment.G, Segment.H, Segment.L, Segment.J),

  /*
     - -
    |   |
     - -
    |   |
   */
  UPPER_A('A', Segment.A, Segment.B, Segment.C, Segment.D, Segment.G, Segment.H, Segment.P, Segment.L),

  /*
     - -
      | |
       -
      | |
     - -
   */
  UPPER_B('B', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.J, Segment.L, Segment.N),

  /*
     - -
    |
    |
     - -
   */
  UPPER_C('C', Segment.A, Segment.B, Segment.E, Segment.F, Segment.G, Segment.H),

  /*
     - -
      | |
      | |
     - -
   */
  UPPER_D('D', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.J, Segment.N),

  /*
     - -
    |
     -
    |
     - -
   */
  UPPER_E('E', Segment.A, Segment.B, Segment.E, Segment.F, Segment.G, Segment.H, Segment.P),

  /*
     - -
    |
     -
    |
   */
  UPPER_F('F', Segment.A, Segment.B, Segment.G, Segment.H, Segment.P),

  /*
     - -
    |
       -
    |   |
     - -
   */
  UPPER_G('G', Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H, Segment.L),

  /*
    |   |
     - -
    |   |
   */
  UPPER_H('H', Segment.C, Segment.D, Segment.G, Segment.H, Segment.P, Segment.L),

  /*
     - -
      |
      |
     - -
   */
  UPPER_I('I', Segment.A, Segment.B, Segment.E, Segment.F, Segment.J, Segment.N),

  /*
        |
    |   |
     - -
   */
  UPPER_J('J', Segment.C, Segment.D, Segment.E, Segment.F, Segment.G),

  /*
    |  /
     - -
    |   |
   */
  UPPER_K('K', Segment.D, Segment.G, Segment.H, Segment.K, Segment.P, Segment.L),

  /*
    |
    |
     - -
   */
  UPPER_L('L', Segment.E, Segment.F, Segment.G, Segment.H),

  /*
    |\ /|
    |   |
   */
  UPPER_M('M', Segment.C, Segment.D, Segment.G, Segment.H, Segment.I, Segment.K),

  /*
    |\  |
    |  \|
   */
  UPPER_N('N', Segment.C, Segment.D, Segment.G, Segment.H, Segment.I, Segment.M),

  /*
     - -
    |   |
    |   |
     - -
   */
  UPPER_O('O', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H),

  /*
     - -
    |   |
     - -
    |
   */
  UPPER_P('P', Segment.A, Segment.B, Segment.C, Segment.G, Segment.H, Segment.P, Segment.L),

  /*
     - -
    |   |
    |  \|
     - -
   */
  UPPER_Q('Q', Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H, Segment.M),

  /*
     - -
    |   |
    |  \
   */
  UPPER_R('R', Segment.A, Segment.B, Segment.C, Segment.G, Segment.H, Segment.M),

  /*
     - -
     \
       -
        |
     - -
   */
  UPPER_S('S', Segment.A, Segment.B, Segment.D, Segment.E, Segment.F, Segment.I, Segment.L),

  /*
     - -
      |
      |
   */
  UPPER_T('T', Segment.A, Segment.B, Segment.J, Segment.N),

  /*
    |   |
    |   |
     - -
   */
  UPPER_U('U', Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H),

  /*
    |  /
    |/
   */
  UPPER_V('V', Segment.G, Segment.H, Segment.K, Segment.O),

  /*
    |   |
    |/ \|
   */
  UPPER_W('W', Segment.C, Segment.D, Segment.G, Segment.H, Segment.O, Segment.M),

  /*
    \ /
    / \
   */
  UPPER_X('X', Segment.I, Segment.K, Segment.O, Segment.M),

  /*
    |   |
     - -
      |
   */
  UPPER_Y('Y', Segment.C, Segment.H, Segment.P, Segment.L, Segment.N),

  /*
    - -
      /
    /
    - -
   */
  UPPER_Z('Z', Segment.A, Segment.B, Segment.E, Segment.F, Segment.K, Segment.O),

  /*
       -
      |
      |
       -
   */
  BRACKET_OPEN('[', Segment.B, Segment.E, Segment.J, Segment.N),

  /*
     \
       \
   */
  BACKSLASH('\\', Segment.I, Segment.M),

  /*
     -
      |
      |
     -
   */
  BRACKET_CLOSE(']', Segment.A, Segment.F, Segment.J, Segment.N),

  /*
     - -
     | |
   */
  UP_ARROW('^', Segment.A, Segment.B, Segment.H, Segment.C),

  /*
     - -
   */
  UNDERSCORE('_', Segment.E, Segment.F),

  /*
     \
   */
  BACKTICK('`', Segment.I),
  /*
     -
    | |
     - -
   */
  LOWER_A('a', Segment.P, Segment.G, Segment.N, Segment.E, Segment.F),

  /*
    |
     -
    | |
     -
   */
  LOWER_B('b', Segment.P, Segment.G, Segment.H, Segment.N, Segment.F),

  /*
     -
    |
     -
   */
  LOWER_C('c', Segment.P, Segment.G, Segment.F),

  /*
      |
     -
    | |
     -
   */
  LOWER_D('d', Segment.C, Segment.D, Segment.E, Segment.L, Segment.N),

  /*
     -
    |/
     -
   */
  LOWER_E('e', Segment.P, Segment.G, Segment.F, Segment.O),

  /*
       -
      |
     - -
      |
   */
  LOWER_F('f', Segment.B, Segment.P, Segment.L, Segment.J, Segment.N),

  /*
     -
    | |
     -
      |
     -
   */
  LOWER_G('g', Segment.A, Segment.J, Segment.P, Segment.N, Segment.F, Segment.H),

  /*
    |
     -
    | |
   */
  LOWER_H('h', Segment.G, Segment.H, Segment.P, Segment.N),

  /*
     |
   */
  LOWER_I('i', Segment.N),

  /*
      |
    | |
     -
   */
  LOWER_J('j', Segment.J, Segment.N, Segment.F, Segment.G),

  /*
     |/
     |\
   */
  LOWER_K('k', Segment.J, Segment.N, Segment.K, Segment.M),

  /*
     |
     |
   */
  LOWER_L('l', Segment.H, Segment.G),

  /*
     - -
    | | |
   */
  LOWER_M('m', Segment.P, Segment.L, Segment.G, Segment.N, Segment.D),

  /*
     -
    | |
   */
  LOWER_N('n', Segment.P, Segment.G, Segment.N),

  /*
     -
    | |
     -
   */
  LOWER_O('o', Segment.P, Segment.G, Segment.N, Segment.F),

  /*
     -
    | |
     -
    |
   */
  LOWER_P('p', Segment.A, Segment.H, Segment.J, Segment.P, Segment.G),

  /*
     -
    | |
     -
      |
   */
  LOWER_Q('q', Segment.A, Segment.H, Segment.J, Segment.P, Segment.N),

  /*
     -
    |
   */
  LOWER_R('r', Segment.G, Segment.P),

  /*
     -
    |
     -
      |
     -
   */
  LOWER_S('s', Segment.A, Segment.N, Segment.F, Segment.H, Segment.P),

  /*
    |
     -
    |
     -
   */
  LOWER_T('t', Segment.F, Segment.G, Segment.H, Segment.P),

  /*
    | |
     -
   */
  LOWER_U('u', Segment.F, Segment.G, Segment.N),

  /*
    |/
   */
  LOWER_V('v', Segment.G, Segment.O),


  /*
    |/\|
   */
  LOWER_W('w', Segment.G, Segment.O, Segment.D, Segment.M),

  /*
    \/
    /\
   */
  LOWER_X('x', Segment.I, Segment.K, Segment.O, Segment.M),

  /*
    | |
     -
      |
     -
   */
  LOWER_Y('y', Segment.C, Segment.D, Segment.E, Segment.J, Segment.L),

  /*
     -
     /
     -
   */
  LOWER_Z('z', Segment.P, Segment.O, Segment.F),

  /*
       -
      |
     -
      |
       -
   */
  BRACE_OPEN('{', Segment.B, Segment.E, Segment.J, Segment.P, Segment.N),

  /*
      |
      |
   */
  PIPE('|', Segment.J, Segment.N),

  /*
     -
      |
       -
      |
     -
   */
  BRACE_CLOSE('}', Segment.A, Segment.L, Segment.F, Segment.J, Segment.N),

  /*
      -
     | | |
        -
   */
  TILDE('~', Segment.A, Segment.C, Segment.L, Segment.J, Segment.H),

  // TODO: Sort below this line

  /*
      \
       -
      /
      - -
   */
  GREATER_OR_EQUAL('≥', Segment.I, Segment.L, Segment.O, Segment.E, Segment.F),

  /*
      /
     -
      \
      - -
   */
  LESS_OR_EQUAL('≤', Segment.K, Segment.M, Segment.P, Segment.E, Segment.F),

  /*
      |
     - -
      |
     - -
   */
  PLUS_MINUS('+', Segment.P, Segment.L, Segment.J, Segment.N, Segment.E, Segment.F),

  /*
     - -
     - -
     - -
   */
  CONGRUENT('≡', Segment.P, Segment.L, Segment.F, Segment.E, Segment.A, Segment.B),

  /*
     - -|
   */
  BOOL_NOT('¬', Segment.P, Segment.L, Segment.D),

  /*
     |- -
   */
  BOOL_NOT_MIRROR('¬', Segment.P, Segment.L, Segment.G),

  /*
     - -
    | | |
     - -
   */
  INFINITY('∞', Segment.A, Segment.B, Segment.C, Segment.P, Segment.L, Segment.J, Segment.H),

  /*
    All segments on, except DP
   */
  BLOCK(
    '█',
    Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G, Segment.H,
    Segment.I, Segment.J, Segment.K, Segment.L, Segment.M, Segment.N, Segment.O, Segment.P
  ),

  /*
     -
    | |
     -
   */
  DEGREE('°', Segment.B, Segment.C, Segment.L, Segment.J),

  // TODO: Pipes and blocks in all combinations

  ;

  companion object {
    private val stateByChar = mutableMapOf<Char, SegmentState>()

    init {
      for (state in SegmentState.values())
        stateByChar[state.character] = state
    }

    fun resolveState(character: Char): SegmentState? {
      return stateByChar[character]
    }
  }

  constructor(character: Char, vararg segments: Segment) : this(character, Util.enumSetFromArray(segments))
}