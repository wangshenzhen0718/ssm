Bean的生命周期之5步
    ● 第一步：实例化Bean
    ● 第二步：Bean属性赋值
    ● 第三步：初始化Bean
    ● 第四步：使用Bean
    ● 第五步：销毁Bean



Bean生命周期之7步:比5步添加在初始化Bean的前和后
    ● 第一步：实例化Bean
    ● 第二步：Bean属性赋值
    ● 第三步：执行Bean后处理器的before方法。
    ● 第四步：初始化Bean
    ● 第五步：执行Bean后处理器的after方法。
    ● 第六步：使用Bean
    ● 第七步：销毁Bean



Bean生命周期之10步:比7步添加在哪里？
    点位1:在"Bean后处理器"before方法之前
        干了什么事儿?
        检查Bean是否实现了Aware相关的接口，如果实现了接口则调用这些接口中的方法。然后调用这些方法的目的是为了给你传递一些数据，让你更加方便使用。
        Aware相关的接口包括：BeanNameAware、BeanClassLoaderAware、BeanFactoryAware
        ● 当Bean实现了BeanNameAware，Spring会将Bean的名字传递给Bean。
        ● 当Bean实现了BeanClassLoaderAware，Spring会将加载该Bean的类加载器传递给Bean。
        ● 当Bean实现了BeanFactoryAware，Spring会将Bean工厂对象传递给Bean。
    点位2:在"Bean后处理器"before方法之后
        干了什么事儿?
        检查Bean是否实现了InitializingBean接口，如果实现了，则调用接口中的方法。
    点位3:使用Bean之后，或者说销毁Bean之前
        干了什么事儿?
        检查Bean是否实现了DisposableBean接口，如果实现了，则调用接口中的方法。
    添加的这三个点位的特点:都是在检查你这个Bean是否实现了某些特定的接口，如果实现了这些接口，则Spring容器会调用这个接口中的方法。



    执行结果
        第一步 构造函数
        第二步 set赋值
        userBean
        Bean这个类的加载器jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b
        生产Bean这个类的工厂是org.springframework.beans.factory.support.DefaultListableBeanFactory@53251a66: defining beans [com.wang.spring6.bean.LogBeanPostProcessor#0,userBean]; root of factory hierarchy
        第三步 执行BeanPostProcessor的before方法！
        InitializingBean的afterPropertiesSet执行！
        第四步 初始化bean
        第五步 执行BeanPostProcessor的after方法！
        第六步 使用Bean
        DisposableBean的destroy执行！！
        第七步 销毁bean