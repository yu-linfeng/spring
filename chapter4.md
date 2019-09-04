# Bean的生命周期

Bean的生命周期也就是Bean在Spring中是如何被创建以及被容器管理，到最后又是如何被销毁的过程。

在```AbstractApplicationContext```中，```refresh```方法是核心中的核心，这个方法包含了IoC容器的创建过程，以及Bean对象的创建过程。

在```refresh```会做很多处理，例如：BeanFactory预处理、注册Bean的后置处理器等等，其中```finishBeanFactoryInitialization```方法实现了Bean实例的创建过程，在```finishBeanFactoryInitialization```方法中的核心方法是调用```DefaultListableBeanFactory```类的```preInstantiateSingletons```方法，本文也将从这个方法讲起。

