package han.test.training.util;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {
    private static class ModelMapperHolder{
        private static final ModelMapper INSTANCE = new ModelMapper();
    }

    public static ModelMapper getModelMapperInstance()
    {
        return ModelMapperHolder.INSTANCE;
    }
}
