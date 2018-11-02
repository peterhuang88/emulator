import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

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

        // init and clear memory
        memory = new char[4096];
        for (int i = 0; i < 4096; i++) {
            memory[i] = 0;
        }

        // load that fontset
        for (int i = 0; i < 80; i++) {
            memory[i] = chip8_fontset[i];
        }

        // TODO: reset timers
    }

    public void loadProgram(String filename) throws IOException {
        File file = new File(filename);

        // load file in binary mode to a byte array buffer
        byte[] b = new byte[(int)file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e1) {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }

        // load program from buffer into memory
        for (int i = 0; i < b.length; i++) {
            memory[i + 512] = (char)b[i];
        }
    }

    public void emulateCycle() {
        
    }
}
