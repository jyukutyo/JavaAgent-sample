package com.jyukutyo;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
//        inst.addTransformer(new ClassFileTransformer() {
//            @Override
//            public byte[] transform(ClassLoader loader, String className,
//                                    Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
//                                    byte[] classfileBuffer) throws IllegalClassFormatException {
//                if (!className.startsWith("com/jyukutyo")) {
//                    return classfileBuffer;
//                }
//
//                ClassPool cp = ClassPool.getDefault();
//                try {
//                    CtClass ct = cp.makeClass(new ByteArrayInputStream(classfileBuffer));
//                    for (CtMethod ctMethod : ct.getDeclaredMethods()) {
//                        ctMethod.insertBefore("System.out.println($args); System.out.println($type);");
//                    }
//                    return ct.toBytecode();
//
//                } catch (IOException | CannotCompileException e) {
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//
//
//            }
//        });
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder transform(DynamicType.Builder builder,
                                                         TypeDescription typeDescription,
                                                         ClassLoader classloader) {
                        return builder.method(ElementMatchers.named("toString"))
                                .intercept(FixedValue.value("transformed"));
                    }
                }).installOn(inst);
    }

}
