public class CPU {
    final char[] chip8_fontset =
    {
            0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
            0x20, 0x60, 0x20, 0x20, 0x70, // 1
            0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
            0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
            0x90, 0x90, 0xF0, 0x10, 0x10, // 4
            0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
            0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
            0xF0, 0x10, 0x20, 0x40, 0x40, // 7
            0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
            0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
            0xF0, 0x90, 0xF0, 0x90, 0x90, // A
            0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
            0xF0, 0x80, 0x80, 0x80, 0xF0, // C
            0xE0, 0x90, 0x90, 0x90, 0xE0, // D
            0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
            0xF0, 0x80, 0xF0, 0x80, 0x80  // F
    };

    // opcode: 2 bytes
    short opcode;

    // memory and registers, each space is 1 byte
    char[] memory;
    char[] V;

    // index register and program counter
    short I;
    short pc;

    // graphics
    char[] gfx;

    // exactly what it says
    char delay_timer;
    char sound_timer;

    // stack and stack pointer
    short[] stack;
    short sp;

    public CPU() {
        pc = 0x200;
        opcode = 0;
        I = 0;
        sp = 0;

        // init and clear display
        gfx = new char[64 * 32];
        for (int i = 0; i <  64 * 32; i++) {
            gfx[i] = 0;
        }

        // init and clear stack
        stack = new short[16];
        for (int i = 0; i < 16; i++) {
            stack[i] = 0;
        }

        // init and clear registers
        V = new char[16];
        for (int i = 0; i < 16; i++) {
            V[i] = 0;
        }





    }

}
