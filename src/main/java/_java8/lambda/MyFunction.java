package _java8.lambda;

@FunctionalInterface
interface MyFunction<T, R> {
    /**
     * 函数方法:
     *  处理两个T类型的对象, 返回R类型的结果
     */
    R get(T t1, T t2);
}

