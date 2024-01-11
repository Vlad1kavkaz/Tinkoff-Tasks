package edu.hw11;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;

public class FibByteCodeAppender implements ByteCodeAppender {
    private static final int STACK_SIZE = 5;
    private static final String FIB_CLASS_NAME = "FibonacciUtils";
    private static final String METHOD_NAME = "fib";

    @SuppressWarnings("ParameterAssignment")
    @Override @NotNull public Size apply(
        MethodVisitor methodVisitor,
        @NotNull Implementation.Context context,
        @NotNull MethodDescription methodDescription
    ) {
        Label label = new Label();

        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
        methodVisitor.visitInsn(Opcodes.ICONST_2);
        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, label);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
        methodVisitor.visitInsn(Opcodes.I2L);
        methodVisitor.visitInsn(Opcodes.LRETURN);
        methodVisitor.visitLabel(label);
        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);

        invokeFibonacciMethod(methodVisitor, Opcodes.ICONST_1);

        invokeFibonacciMethod(methodVisitor, Opcodes.ICONST_2);

        methodVisitor.visitInsn(Opcodes.LADD);
        methodVisitor.visitInsn(Opcodes.LRETURN);

        return new Size(STACK_SIZE, 0);
    }

    private static void invokeFibonacciMethod(MethodVisitor methodVisitor, int param) {
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
        methodVisitor.visitInsn(param);
        methodVisitor.visitInsn(Opcodes.ISUB);
        methodVisitor.visitMethodInsn(
            Opcodes.INVOKEVIRTUAL,
            FIB_CLASS_NAME,
            METHOD_NAME,
            "(I)J",
            false
        );
    }
}
