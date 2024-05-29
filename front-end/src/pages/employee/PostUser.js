import { useState } from "react";
import Form from "react-bootstrap/Form"
import Button from "react-bootstrap/Button"
import "./PostUser.css";

const PostUser = () =>{

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        phone: "",
        department: ""
    })

    const handleInputChange = (event) =>{
        const {name, value} = event.target;
        setFormData({
            ...formData,
            [name]:value,
        })
    }

    return (
        <div className="center-form">
            <h1>Post New Employee</h1>
            <Form>
                <Form.Group controlId="formBasicName">
                    <Form.Control
                        type="text"
                        name="name"
                        placeholder="Enter name"
                        value={formData.name}
                        onChange={handleInputChange}
                    />
                </Form.Group>
                <Form.Group controlId="formBasicName">
                    <Form.Control
                        type="email"
                        name="email"
                        placeholder="Enter email"
                        value={formData.email}
                        onChange={handleInputChange}
                    />
                </Form.Group>
                <Form.Group controlId="formBasicName">
                    <Form.Control
                        type="text"
                        name="email"
                        placeholder="Enter phone"
                        value={formData.phone}
                        onChange={handleInputChange}
                    />
                </Form.Group>
                <Form.Group controlId="formBasicName">
                    <Form.Control
                        type="text"
                        name="department"
                        placeholder="Enter department"
                        value={formData.department}
                        onChange={handleInputChange}
                    />
                </Form.Group>
                <Button variant="primary" type="submit" className="w-100">
                    Post Employee
                </Button>
            </Form>
        </div>
    )
}

export default PostUser;
