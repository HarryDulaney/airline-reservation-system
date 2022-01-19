package com.application.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {

            @Override
            protected void configure() {

//                mapping(VehicleTypeGroup.class, BaseModelDto.class)
//                        .fields("vehicleTypeGroupCode", "code")
//                        .fields("vehicleTypeGroupDescription", "description");
//                mapping(ReportDataStatus.class, BaseModelDto.class)
//                        .fields("dataStatusCode", "code")
//                        .fields("dataStatusDescription", "description",
//                                customConverter("com.gm.gsmc.nadpa.common.NullValueConverter")
//                        );
//                mapping(Objectt.class, ObjecttDto.class)
//                        .fields("tableOwner", "tableOwner")
//                        .fields("tableModule", "tableModule")
//                        .fields("tableName", "tableName")
//                        .fields("tableDescription", "tableDescription")
//                        .fields("tableWindowObjectNumber", "tableWindowObjectNumber")
//                        .fields("filter", "filter",
//                                customConverter("com.gm.gsmc.nadpa.common.YesNoConverter")
//                        )
//                        .fields("special", "special",
//                                customConverter("com.gm.gsmc.nadpa.common.YesNoConverter")
//                        )
//                        .fields("readOnlyColumns", "readOnlyColumns");

            }
        };
    }

    @Bean(name = "MapperBean")
    public DozerBeanMapper beanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
//        dozerBeanMapper.setMappingFiles(getMappingFiles());
        return dozerBeanMapper;
    }


//    private List<String> getMappingFiles() {
//        List<String> mappingFiles = new ArrayList<>();
//        mappingFiles.add("dozer-configuration.xml");
//        return mappingFiles;
//    }
}
