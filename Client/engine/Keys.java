package engine;

public enum Keys {
	BACK(8),
	TAB(9),
	ENTER(10),
	SHIFT(16),
	CTRL(17),
	ALT(18),
	PAUSE(19),
	CAPSLOCK(20),
	ESCAPE(27),
	SPACE(32),
	PAGEUP(33),
	PAGEDOWN(34),
	END(35),
	HOME(36),
	LEFT(37), 
	UP(38), 
	RIGHT(39), 
	DOWN(40),
	INSERT(45),
	DELETE(46),
	D0(48),
	D1(49),
	D2(50),
	D3(51),
	D4(52),
	D5(53),
	D6(54),
	D7(55),
	D8(56),
	D9(57),
	EQUALS(61),
	A(65),
	B(66),
	C(67),
	D(68),
	E(69),
	F(70),
	G(71),
	H(72),
	I(73),
	J(74),
	K(75),
	L(76),
	M(77),
	N(78),
	O(79),
	P(80),
	Q(81),
	R(82),
	S(83),
	T(84),
	U(85),
	V(86),
	W(87),
	X(88),
	Y(89),
	Z(90),
	WINDOWS(91),
	NUM0(96),
	NUM1(97),
	NUM2(98),
	NUM3(99),
	NUM4(100),
	NUM5(101),
	NUM6(102),
	NUM7(103),
	NUM8(104),
	NUM9(105),
	MULTIPLY(106),
	ADD(107),
	SUBTRACT(109),
	DECIMAL(110),
	DIVIDE(111),
	F1(112),
	F2(113),
	F3(114),
	F4(115),
	F5(116),
	F6(117),
	F7(118),
	F8(119),
	F9(120),
	F10(121),
	F11(122),
	F12(123),
	NUMLOCK(144),
	SCROLLLOCK(145),
	COMMA(188),
	PERIOD(190),
	FORWARDSLASH(191),
	BACKTICK(192),
	LBRACKET(219),
	BACKSLASH(220),
	RBRACKET(221),
	APOSTROPHE(222);

	private final Integer keyCode;

	Keys(Integer keyCode) {
		this.keyCode = keyCode;
	}

	public Integer getKeyCode() {
		return keyCode;
	}

	public static Keys indexOf(Integer value) {
		for (Keys key : Keys.values()) {
			if (key.getKeyCode() == value) {
				return key;
			}
		}

		return null;
	}
}

//this would be more efficient for indexOf(), but it takes up a lot of code and memory
//private static Map<Integer, Keys> KeyMap = new HashMap<Integer, Keys>();
//static {
//	Map<Integer, Keys> initMap = new HashMap<Integer, Keys>();
//	initMap.put(8, Keys.BACK);
//	initMap.put(9, Keys.TAB);
//	initMap.put(13, Keys.ENTER);
//	
//  ... snip ...
//
//	KeyMap = Collections.unmodifiableMap(initMap);
//};
