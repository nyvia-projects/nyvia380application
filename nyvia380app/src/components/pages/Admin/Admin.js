import "./Admin.css"

import { Table } from "react-bootstrap"
import apiClient from "services/apiClient"
import { useEffect, useState } from "react"

function Admin () {

    const [userData, setUserData] = useState([])

    useEffect(() => {
        const fetch = async () => {
            const data = await apiClient.fetchAllUsers()
            setUserData(data.data)
        }

        fetch()
    }, [])


    const loadUsers = () => {
        return userData.map((element, index) => {
            return (
                <tr>
                    <td>{index}</td>
                    <td>{element?.firstName}</td>
                    <td>{element?.lastName}</td>
                    <td>{element?.age}</td>
                    <td>{element?.privilege}</td>
                    <td>{element?.alias}</td>
                    <td>{element?.groups}</td>
                </tr>
            )
        })
    }

    return (
        <div className="Admin">
            <div className="user-table">
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <th>id #</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                            <th>Privelage</th>
                            <th>Alias</th>
                            <th>Groups</th>
                        </tr>
                    </thead>
                    <tbody>
                        {loadUsers()}
                    </tbody>
                </Table>
            </div>
        </div>
    )
}

export default Admin;