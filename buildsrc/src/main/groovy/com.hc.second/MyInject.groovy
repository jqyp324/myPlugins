package com.hc.second

class MyInject {

    public static void injectDir(String path, String packageName) {

        File dir = new File(path)
        if (dir.isDirectory()) {
            dir.eachFileRecurse { File file ->

                String filePath = file.absolutePath
                //确保当前文件是class文件，并且不是系统自动生成的class文件
                if (filePath.endsWith(".class")
                        && !filePath.contains('R$')
                        && !filePath.contains('R.class')
                        && !filePath.contains("BuildConfig.class")) {
                    // 判断当前目录是否是在我们的应用包里面
                    println("============" + filePath)
//                    int index = filePath.indexOf(packageName);
//                    boolean isMyPackage = index != -1;
//                    if (isMyPackage) {
//                        int end = filePath.length() - 6 // .class = 6
//                        String className = filePath.substring(index, end).replace('\\', '.').replace('/', '.')
//                        //开始修改class文件
//                        CtClass c = pool.getCtClass(className)
//
//                        if (c.isFrozen()) {
//                            c.defrost()
//                        }
//
//                        CtConstructor[] cts = c.getDeclaredConstructors()
//                        pool.importPackage("android.util.Log");
//                        if (cts == null || cts.length == 0) {
//                            //手动创建一个构造函数
//                            CtConstructor constructor = new CtConstructor(new CtClass[0], c)
//                            constructor.insertBeforeBody(injectStr)
//                            c.addConstructor(constructor)
//                        } else {
//                            cts[0].insertBeforeBody(injectStr)
//                        }
//                        c.writeFile(path)
//                        c.detach()
//                    }
                }
            }
        }
    }

}