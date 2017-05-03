/*
 * Copyright (C) 2017 stephan
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package db.postgres;

import db.interfaces.ActivityRepository;
import db.interfaces.DatabaseEngine;
import db.interfaces.ProjectMemberRepository;
import db.interfaces.ProjectPhaseRepository;
import db.interfaces.ProjectRepository;
import db.interfaces.UserRepository;

/**
 * @created $date
 * @author stephan
 */
public class DatabaseEnginePostgres extends DatabaseEngine
{
    static DatabaseEnginePostgres theInstance;
    public static DatabaseEnginePostgres getInstance()
    {
        if(theInstance == null)
            theInstance = new DatabaseEnginePostgres();
        return theInstance;
    }
    private DatabaseEnginePostgres()
    {
        
    }
    
    @Override
    public boolean connect()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean disconnect()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserRepository getUserRepository()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProjectRepository getProjectRepository()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProjectMemberRepository getProjectMemberRepository()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProjectPhaseRepository getProjectPhaseRepository()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivityRepository getActivityRepository()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
